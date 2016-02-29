package deltaanalytics.ftirweb.dto;

public class JuekeParameterDto {
    private boolean valve1Enabled;
    private boolean valve2Enabled;
    private boolean valve3Enabled;
    private boolean valve4Enabled;
    private boolean valve5Enabled;
    private boolean valve6Enabled;
    private boolean valve7Enabled;
    private boolean valve8Enabled;
    private double temperature;
    private double pressure;
    private double pumpSpeed;

    public boolean isValve1Enabled() {
        return valve1Enabled;
    }

    public void setValve1Enabled(boolean valve1Enabled) {
        this.valve1Enabled = valve1Enabled;
    }

    public boolean isValve2Enabled() {
        return valve2Enabled;
    }

    public void setValve2Enabled(boolean valve2Enabled) {
        this.valve2Enabled = valve2Enabled;
    }

    public boolean isValve3Enabled() {
        return valve3Enabled;
    }

    public void setValve3Enabled(boolean valve3Enabled) {
        this.valve3Enabled = valve3Enabled;
    }

    public boolean isValve4Enabled() {
        return valve4Enabled;
    }

    public void setValve4Enabled(boolean valve4Enabled) {
        this.valve4Enabled = valve4Enabled;
    }

    public boolean isValve5Enabled() {
        return valve5Enabled;
    }

    public void setValve5Enabled(boolean valve5Enabled) {
        this.valve5Enabled = valve5Enabled;
    }

    public boolean isValve6Enabled() {
        return valve6Enabled;
    }

    public void setValve6Enabled(boolean valve6Enabled) {
        this.valve6Enabled = valve6Enabled;
    }

    public boolean isValve7Enabled() {
        return valve7Enabled;
    }

    public void setValve7Enabled(boolean valve7Enabled) {
        this.valve7Enabled = valve7Enabled;
    }

    public boolean isValve8Enabled() {
        return valve8Enabled;
    }

    public void setValve8Enabled(boolean valve8Enabled) {
        this.valve8Enabled = valve8Enabled;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getPumpSpeed() {
        return pumpSpeed;
    }

    public void setPumpSpeed(double pumpSpeed) {
        this.pumpSpeed = pumpSpeed;
    }

    @Override
    public String toString() {
        return "JuekeParameterDto{" +
                "valve1Enabled=" + valve1Enabled +
                ", valve2Enabled=" + valve2Enabled +
                ", valve3Enabled=" + valve3Enabled +
                ", valve4Enabled=" + valve4Enabled +
                ", valve5Enabled=" + valve5Enabled +
                ", valve6Enabled=" + valve6Enabled +
                ", valve7Enabled=" + valve7Enabled +
                ", valve8Enabled=" + valve8Enabled +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", pumpSpeed=" + pumpSpeed +
                '}';
    }
}
