package com.example.tugasp7_sqlite;

public class Museum {
    private String _id, _namamuseum, _alamat, _email;
    public Museum (String id, String nama, String alamat, String email) {
        this._id = id;
        this._namamuseum = nama;
        this._alamat = alamat;
        this._email = email;
    }
    public Museum() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_namamuseum() {
        return _namamuseum;
    }
    public void set_namamuseum(String _namamuseum) {
        this._namamuseum = _namamuseum;
    }
    public String get_alamat() {
        return _alamat;
    }
    public void set_alamat(String _alamat) {
        this._alamat = _alamat;
    }
    public String get_email() {
        return _email;
    }
    public void set_email(String _email) {
        this._email = _email;
    }
}



