package deltaanalytics.ftirweb.dto;


import java.io.Serializable;

/** ToDo get parameters from GUI
 *  vector of initial parameters for use of Hitran data base
 *  base class for all molecules
 */
public class HitranParametersDto implements Serializable {
    private long id;
    private boolean callHitran;  // call Hitran function before doing nonlinear fit true/false
    private int molecule;   // which moleclue to investigate 1=H2O  2=CO2  3=N2O  4=CO  5=CH4  6=NO  7=NO2
    private boolean currentDefault;
    private double lowWN;  // low wavenumbers
    private double highWN;  // high wavenumbers
    private int baselineStep;  // sampling point interval to fit a baseline curve
    private double stp;  // default 0.02; frequency hitran spacing in cm-1, 0.02 corresponds to 0.04 resolution in cm-1
    private double intensThres1; // intensity threshold1 1e-25
    private int isotopo1;  //default 1
    private double intensThres2; // intensity threshold2 1e-25
    private int isotopo2;  // default 2
    private double sf;  // default 1; scaling factor isotopo2
    private double Temp;  // default = 313 Kelvin; Temperature 40 °C
    private double Patm;  // default = 1 atm; total Pressure in ATM units
    private int Dd;  // default = 5; wings of each line in wavenumbers of cm-1

    public HitranParametersDto(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isCallHitran() {
        return callHitran;
    }

    public void setCallHitran(boolean callHitran) {
        this.callHitran = callHitran;
    }

    public int getMolecule() {
        return molecule;
    }

    public void setMolecule(int molecule) {
        this.molecule = molecule;
    }

    public boolean isCurrentDefault() {
        return currentDefault;
    }

    public void setCurrentDefault(boolean currentDefault) {
        this.currentDefault = currentDefault;
    }

    public double getLowWN() {
        return lowWN;
    }

    public void setLowWN(double lowWN) {
        this.lowWN = lowWN;
    }

    public double getHighWN() {
        return highWN;
    }

    public void setHighWN(double highWN) {
        this.highWN = highWN;
    }

    public int getBaselineStep() {
        return baselineStep;
    }

    public void setBaselineStep(int baselineStep) {
        this.baselineStep = baselineStep;
    }

    public double getStp() {
        return stp;
    }

    public void setStp(double stp) {
        this.stp = stp;
    }

    public double getIntensThres1() {
        return intensThres1;
    }

    public void setIntensThres1(double intensThres1) {
        this.intensThres1 = intensThres1;
    }

    public int getIsotopo1() {
        return isotopo1;
    }

    public void setIsotopo1(int isotopo1) {
        this.isotopo1 = isotopo1;
    }

    public double getIntensThres2() {
        return intensThres2;
    }

    public void setIntensThres2(double intensThres2) {
        this.intensThres2 = intensThres2;
    }

    public int getIsotopo2() {
        return isotopo2;
    }

    public void setIsotopo2(int isotopo2) {
        this.isotopo2 = isotopo2;
    }

    public double getSf() {
        return sf;
    }

    public void setSf(double sf) {
        this.sf = sf;
    }

    public double getTemp() {
        return Temp;
    }

    public void setTemp(double temp) {
        Temp = temp;
    }

    public double getPatm() {
        return Patm;
    }

    public void setPatm(double patm) {
        Patm = patm;
    }

    public int getDd() {
        return Dd;
    }

    public void setDd(int dd) {
        Dd = dd;
    }

    @Override
    public String toString() {
        return "HitranParametersDto{" +
                "id=" + id +
                ", callHitran=" + callHitran +
                ", molecule=" + molecule +
                ", currentDefault=" + currentDefault +
                ", lowWN=" + lowWN +
                ", highWN=" + highWN +
                ", baselineStep=" + baselineStep +
                ", stp=" + stp +
                ", intensThres1=" + intensThres1 +
                ", isotopo1=" + isotopo1 +
                ", intensThres2=" + intensThres2 +
                ", isotopo2=" + isotopo2 +
                ", sf=" + sf +
                ", Temp=" + Temp +
                ", Patm=" + Patm +
                ", Dd=" + Dd +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HitranParametersDto that = (HitranParametersDto) o;

        if (id != that.id) return false;
        if (callHitran != that.callHitran) return false;
        if (molecule != that.molecule) return false;
        if (currentDefault != that.currentDefault) return false;
        if (Double.compare(that.lowWN, lowWN) != 0) return false;
        if (Double.compare(that.highWN, highWN) != 0) return false;
        if (baselineStep != that.baselineStep) return false;
        if (Double.compare(that.stp, stp) != 0) return false;
        if (Double.compare(that.intensThres1, intensThres1) != 0) return false;
        if (isotopo1 != that.isotopo1) return false;
        if (Double.compare(that.intensThres2, intensThres2) != 0) return false;
        if (isotopo2 != that.isotopo2) return false;
        if (Double.compare(that.sf, sf) != 0) return false;
        if (Double.compare(that.Temp, Temp) != 0) return false;
        if (Double.compare(that.Patm, Patm) != 0) return false;
        return Dd == that.Dd;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (callHitran ? 1 : 0);
        result = 31 * result + molecule;
        result = 31 * result + (currentDefault ? 1 : 0);
        temp = Double.doubleToLongBits(lowWN);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(highWN);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + baselineStep;
        temp = Double.doubleToLongBits(stp);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(intensThres1);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + isotopo1;
        temp = Double.doubleToLongBits(intensThres2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + isotopo2;
        temp = Double.doubleToLongBits(sf);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(Temp);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(Patm);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Dd;
        return result;
    }
}