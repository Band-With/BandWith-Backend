package com.bandwith.domain;

import java.util.Date;

public class Band {
    private int band_id;
    private String band_name;
    private Date created_at;

    public Band() {
    }

    public Band(int band_id, String band_name, Date created_at) {
        this.band_id = band_id;
        this.band_name = band_name;
        this.created_at = created_at;
    }

    public int getBand_id() {
        return band_id;
    }

    public void setBand_id(int band_id) {
        this.band_id = band_id;
    }

    public String getBand_name() {
        return band_name;
    }

    public void setBand_name(String band_name) {
        this.band_name = band_name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
