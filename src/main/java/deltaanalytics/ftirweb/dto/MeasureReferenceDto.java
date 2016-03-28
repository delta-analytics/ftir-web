package deltaanalytics.ftirweb.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

public class MeasureReferenceDto {
    private long id;

    private BrukerParametersDto brukerParameters;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private BrukerStateEnumDto brukerStateEnum;
    private String error;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public BrukerParametersDto getBrukerParameters() {
        return brukerParameters;
    }

    public void setBrukerParameters(BrukerParametersDto brukerParameters) {
        this.brukerParameters = brukerParameters;
    }

    @Column
    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    @Column
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BrukerStateEnumDto getBrukerStateEnum() {
        return brukerStateEnum;
    }

    public void setBrukerStateEnum(BrukerStateEnumDto brukerStateEnum) {
        this.brukerStateEnum = brukerStateEnum;
    }

    @Lob
    @Column
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
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
