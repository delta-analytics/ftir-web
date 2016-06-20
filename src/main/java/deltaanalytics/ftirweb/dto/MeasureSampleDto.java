package deltaanalytics.ftirweb.dto;

import java.time.LocalDateTime;

public class MeasureSampleDto {
    private long id;
    private MutableBrukerParametersDto brukerParameters;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private BrukerStateEnumDto brukerStateEnum;
    private String filename;
    private String error;
    private MoleculeResultsDto moleculeResultsDto;

    public MeasureSampleDto(long id, MutableBrukerParametersDto mutableBrukerParametersDto, LocalDateTime createdAt,
                            LocalDateTime finishedAt, BrukerStateEnumDto brukerStateEnumDto, String filename,
                            String error, MoleculeResultsDto moleculeResultsDto) {
        this.id = id;
        this.brukerParameters = mutableBrukerParametersDto;
        this.createdAt = createdAt;
        this.finishedAt = finishedAt;
        this.brukerStateEnum = brukerStateEnumDto;
        this.filename = filename;
        this.error = error;
        this.moleculeResultsDto = moleculeResultsDto;
    }

    public long getId() {
        return id;
    }

    public MutableBrukerParametersDto getBrukerParameters() {
        return brukerParameters;
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

    public String getFilename() {
        return filename;
    }

    public String getError() {
        return error;
    }

    public MoleculeResultsDto getMoleculeResultsDto() {
        return moleculeResultsDto;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasureSampleDto that = (MeasureSampleDto) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
