package vn.myclass.command;

import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.web.command.AbstractCommand;

/**
 * Created by TuanKul on 9/23/2017.
 */
public class ListenGuideLineCommand extends AbstractCommand<ListenGuidelineDTO> {
    public ListenGuideLineCommand() {
        this.pojo = new ListenGuidelineDTO();

    }
}
