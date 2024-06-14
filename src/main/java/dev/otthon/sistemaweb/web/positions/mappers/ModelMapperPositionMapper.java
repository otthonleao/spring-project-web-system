package dev.otthon.sistemaweb.web.positions.mappers;

import dev.otthon.sistemaweb.core.models.Position;
import dev.otthon.sistemaweb.web.positions.dtos.PositionForm;
import dev.otthon.sistemaweb.web.positions.dtos.PositionListItem;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(
        name = "dev.otthon.sistemaweb.mappers.provider",
        havingValue = "modelmapper"
)
public class ModelMapperPositionMapper implements PositionMapper{

    private final ModelMapper modelMapper;

//     Construtor foi substituito pela annotation @RequiredArgsConstrutor
//    public ModelMapperPositionMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }

    @Override
    public PositionForm toPositionForm(Position position) {
        return modelMapper.map(position, PositionForm.class);
    }

    @Override
    public Position toPosition(PositionForm positionForm) {
        System.out.println("Utilizando a lib modelmapper");
        return modelMapper.map(positionForm, Position.class);
    }

    @Override
    public PositionListItem toPositionListItem(Position position) {
        return modelMapper.map(position, PositionListItem.class);
    }
}
