package deltaanalytics.ftirweb.dto;

import java.time.LocalDateTime;

public class MeasureReferenceDto {
    private long id;

    private MutableBrukerParametersDto brukerParameters;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private BrukerStateEnumDto brukerStateEnum;
    private String error;

    public long getId() {
        return id;
    }


    public MutableBrukerParametersDto getBrukerParameters() {
        return brukerParameters;
    }

    public void setBrukerParameters(MutableBrukerParametersDto brukerParameters) {
        this.brukerParameters = brukerParameters;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public BrukerStateEnumDto getBrukerStateEnum() {
        return brukerStateEnum;
    }


    public String getError() {
        return error;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasureReferenceDto that = (MeasureReferenceDto) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
