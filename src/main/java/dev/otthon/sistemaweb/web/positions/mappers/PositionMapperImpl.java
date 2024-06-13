package dev.otthon.sistemaweb.web.positions.mappers;

import dev.otthon.sistemaweb.core.models.Position;
import dev.otthon.sistemaweb.web.positions.dtos.PositionForm;
import dev.otthon.sistemaweb.web.positions.dtos.PositionListItem;
import org.springframework.stereotype.Component;

@Component
public class PositionMapperImpl implements PositionMapper {
    @Override
    public PositionForm toPositionForm(Position position) {
        return PositionForm.builder()
                .name(position.getName())
                .build();
    }

    @Override
    public Position toPosition(PositionForm positionForm) {
        return Position.builder()
                .name(positionForm.getName())
                .build();
    }

    @Override
    public PositionListItem toPositionListItem(Position position) {
        return PositionListItem.builder()
                .id(position.getId())
                .name(position.getName())
                .build();
    }
}
