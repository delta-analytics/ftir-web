package deltaanalytics.ftirweb.dto;

import java.util.ArrayList;
import java.util.List;

public class MoleculeResultsDto {
    private long id;
    private List<MoleculeResultDto> allMolecules = new ArrayList<>();

    public MoleculeResultsDto(long id, List<MoleculeResultDto> moleculeResultsDtos) {
        this.id = id;
        this.allMolecules = moleculeResultsDtos;
    }

    public long getId() {
        return id;
    }


    public List<MoleculeResultDto> getMoleculeResultList() {
        return allMolecules;
    }

}
