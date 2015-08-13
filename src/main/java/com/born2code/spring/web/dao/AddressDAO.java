package com.born2code.spring.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

@Component("addressDao")
public class AddressDAO {
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    public List<Address> getAddresses() {

        return jdbc.query("SELECT * from address", new RowMapper<Address>() {
            public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
                Address address = new Address();
                address.setId(rs.getInt("id"));
                address.setStreet(rs.getString("street"));
                address.setPostcode(rs.getString("postcode"));
                address.setCity(rs.getString("city"));
                address.setCountry(rs.getString("country"));

                return address;
            }
        });
    }

    public boolean createAddress(Address address){
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(address);
        return jdbc.update("insert into address(street,postcode,city,country) values (:street,:postcode,:city,:country)", params) == 1;
    }

    @Transactional
    public int[] createAddress(List<Address> addresses){
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(addresses.toArray());

        return jdbc.batchUpdate("insert into address(street,postcode,city, country) values (:street,:postcode,:city,:country)", params);
    }

    public boolean updateAddress(Address address){
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(address);
        return jdbc.update("update address set street=:street,postcode=:postcode,city=:city,country=:country where id=:id", params) == 1;

    }

    public boolean deleteAddress(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.update("delete from address where id=:id", params) == 1;
    }

    public Address getAddress(int id) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.queryForObject("SELECT * from address where id = :id", params, new RowMapper<Address>() {
            public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
                Address address = new Address();
                address.setId(rs.getInt("id"));
                address.setStreet(rs.getString("street"));
                address.setPostcode(rs.getString("postcode"));
                address.setCity(rs.getString("city"));
                address.setCountry(rs.getString("country"));

                return address;
            }
        });
    }

}
