package dev.otthon.sistemaweb.web.positions.mappers;

import dev.otthon.sistemaweb.core.models.Position;
import dev.otthon.sistemaweb.web.positions.dtos.PositionForm;
import dev.otthon.sistemaweb.web.positions.dtos.PositionListItem;

public interface PositionMapper {

    PositionForm toPositionForm(Position position);

    Position toPosition(PositionForm positionForm);

    PositionListItem toPositionListItem(Position position);

}
