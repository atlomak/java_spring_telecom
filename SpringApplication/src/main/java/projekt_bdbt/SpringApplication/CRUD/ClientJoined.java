package projekt_bdbt.SpringApplication.CRUD;

public class ClientJoined {
    int ID_KLIENTA;
    int ID_ADRESU;
    String IMIE;
    String NAZWISKO;
    String PESEL;
    String NUMER_TELEFONU;
    String MIEJSCOWOSC;
    String ULICA;
    String NUMER_BUDYNKU;
    String NUMER_LOKALU;

    public ClientJoined() {
    }

    public ClientJoined(int ID_KLIENTA, String IMIE, String NAZWISKO, String PESEL, String NUMER_TELEFONU, String MIEJSCOWOSC, String ULICA, String NUMER_BUDYNKU, String NUMER_LOKALU) {
        this.ID_KLIENTA = ID_KLIENTA;
        this.IMIE = IMIE;
        this.NAZWISKO = NAZWISKO;
        this.PESEL = PESEL;
        this.NUMER_TELEFONU = NUMER_TELEFONU;
        this.MIEJSCOWOSC = MIEJSCOWOSC;
        this.ULICA = ULICA;
        this.NUMER_BUDYNKU = NUMER_BUDYNKU;
        this.NUMER_LOKALU = NUMER_LOKALU;
    }

    public ClientJoined(int ID_KLIENTA, int ID_ADRESU, String IMIE, String NAZWISKO, String PESEL, String NUMER_TELEFONU, String MIEJSCOWOSC, String ULICA, String NUMER_BUDYNKU, String NUMER_LOKALU) {
        this.ID_KLIENTA = ID_KLIENTA;
        this.ID_ADRESU = ID_ADRESU;
        this.IMIE = IMIE;
        this.NAZWISKO = NAZWISKO;
        this.PESEL = PESEL;
        this.NUMER_TELEFONU = NUMER_TELEFONU;
        this.MIEJSCOWOSC = MIEJSCOWOSC;
        this.ULICA = ULICA;
        this.NUMER_BUDYNKU = NUMER_BUDYNKU;
        this.NUMER_LOKALU = NUMER_LOKALU;
    }

    public int getID_ADRESU() {
        return ID_ADRESU;
    }

    public void setID_ADRESU(int ID_ADRESU) {
        this.ID_ADRESU = ID_ADRESU;
    }

    public int getID_KLIENTA() {
        return ID_KLIENTA;
    }

    public void setID_KLIENTA(int ID_KLIENTA) {
        this.ID_KLIENTA = ID_KLIENTA;
    }

    public String getIMIE() {
        return IMIE;
    }

    public void setIMIE(String IMIE) {
        this.IMIE = IMIE;
    }

    public String getNAZWISKO() {
        return NAZWISKO;
    }

    public void setNAZWISKO(String NAZWISKO) {
        this.NAZWISKO = NAZWISKO;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getNUMER_TELEFONU() {
        return NUMER_TELEFONU;
    }

    public void setNUMER_TELEFONU(String NUMER_TELEFONU) {
        this.NUMER_TELEFONU = NUMER_TELEFONU;
    }

    public String getMIEJSCOWOSC() {
        return MIEJSCOWOSC;
    }

    public void setMIEJSCOWOSC(String MIEJSCOWOSC) {
        this.MIEJSCOWOSC = MIEJSCOWOSC;
    }

    public String getULICA() {
        return ULICA;
    }

    public void setULICA(String ULICA) {
        this.ULICA = ULICA;
    }

    public String getNUMER_BUDYNKU() {
        return NUMER_BUDYNKU;
    }

    public void setNUMER_BUDYNKU(String NUMER_BUDYNKU) {
        this.NUMER_BUDYNKU = NUMER_BUDYNKU;
    }

    public String getNUMER_LOKALU() {
        return NUMER_LOKALU;
    }

    public void setNUMER_LOKALU(String NUMER_LOKALU) {
        this.NUMER_LOKALU = NUMER_LOKALU;
    }

    @Override
    public String toString() {
        return "ClientJoined{" +
                "ID_KLIENTA=" + ID_KLIENTA +
                ", ID_ADRESU=" + ID_ADRESU +
                ", IMIE='" + IMIE + '\'' +
                ", NAZWISKO='" + NAZWISKO + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", NUMER_TELEFONU='" + NUMER_TELEFONU + '\'' +
                ", MIEJSCOWOSC='" + MIEJSCOWOSC + '\'' +
                ", ULICA='" + ULICA + '\'' +
                ", NUMER_BUDYNKU='" + NUMER_BUDYNKU + '\'' +
                ", NUMER_LOKALU='" + NUMER_LOKALU + '\'' +
                '}';
    }
}
