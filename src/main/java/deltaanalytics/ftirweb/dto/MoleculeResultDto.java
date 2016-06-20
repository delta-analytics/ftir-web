package deltaanalytics.ftirweb.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class MoleculeResultDto {
    private long id;

    private int molecule;
    private double mixingRatioFromIntegralUnderTheCurve;
    private double mixingRatioFromHitranSum;
    private double r2;
    private double timeInSecForLevenbergMarquardtFit;
    private double estimatedFov;
    private double fovLineShift;
    private double additionalLineShift;
    private double effectiveResolution;
    private double amplitudeFitFactor;
    private double offsetFitConstant;

    public MoleculeResultDto(long id, int molecule, double mixingRatioFromIntegralUnderTheCurve, double mixingRatioFromHitranSum,
                             double r2, double timeInSecForLevenbergMarquardtFit, double estimatedFov, double fovLineShift,
                             double additionalLineShift, double effectiveResolution, double amplitudeFitFactor, double offsetFitConstant){
        this.id = id;
        this.molecule = molecule;
        this.mixingRatioFromIntegralUnderTheCurve = mixingRatioFromIntegralUnderTheCurve;
        this.mixingRatioFromHitranSum = mixingRatioFromHitranSum;
        this.r2 = r2;
        this.timeInSecForLevenbergMarquardtFit = timeInSecForLevenbergMarquardtFit;
        this.estimatedFov = estimatedFov;
        this.fovLineShift = fovLineShift;
        this.additionalLineShift = additionalLineShift;
        this.effectiveResolution = effectiveResolution;
        this.amplitudeFitFactor = amplitudeFitFactor;
        this.offsetFitConstant = offsetFitConstant;
    }

    public long getId() {
        return id;
    }

    public double getMixingRatioFromIntegralUnderTheCurve() {
        return mixingRatioFromIntegralUnderTheCurve;
    }

    public double getMixingRatioFromHitranSum() {
        return mixingRatioFromHitranSum;
    }

    public double getR2() {
        return r2;
    }

    public double getTimeInSecForLevenbergMarquardtFit() {
        return timeInSecForLevenbergMarquardtFit;
    }

    public double getEstimatedFov() {
        return estimatedFov;
    }

    public double getFovLineShift() {
        return fovLineShift;
    }

    public double getAdditionalLineShift() {
        return additionalLineShift;
    }

    public double getEffectiveResolution() {
        return effectiveResolution;
    }

    public double getAmplitudeFitFactor() {
        return amplitudeFitFactor;
    }

    public double getOffsetFitConstant() {
        return offsetFitConstant;
    }

    public int getMolecule() {
        return molecule;
    }
}
