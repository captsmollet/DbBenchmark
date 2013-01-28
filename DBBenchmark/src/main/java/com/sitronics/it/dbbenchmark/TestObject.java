package com.sitronics.it.dbbenchmark;

import java.sql.Date;

/**
 * Date: 28.01.13
 * Time: 21:38
 */
class TestObject {

    int id;
    java.sql.Date some_date;
    String some_str;

        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSome_date() {
        return some_date;
    }

    public void setSome_date(Date some_date) {
        this.some_date = some_date;
    }

    public String getSome_str() {
        return some_str;
    }

    public void setSome_str(String some_str) {
        this.some_str = some_str;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "id=" + id +
                ", some_date=" + some_date +
                ", some_str='" + some_str + '\'' +
                '}';
    }
}
