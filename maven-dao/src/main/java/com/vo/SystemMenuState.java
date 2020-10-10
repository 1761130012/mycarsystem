package com.vo;

import lombok.Data;

@Data
public class SystemMenuState {
    private boolean checked;//选中节点
    private boolean expanded;//展开
    private boolean selected;//选择节点

    public SystemMenuState(boolean checked) {
        this.checked = checked;
    }
}
