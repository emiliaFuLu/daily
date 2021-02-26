package statueMachine;

/**
 * @author: fl
 * @data: 2020-12-23 14:30
 * @description: 请假类型
 **/
public enum LeavePermitEnum {

    /**
     * annual_leave
     */
    ANNUAL_LEAVE("annual_leave", "年休假"),
    /**
     * casual_leave
     */
    CASUAL_LEAVE("casual_leave", "事假"),
    /**
     * medical_leave
     */
    MEDICAL_LEAVE("medical_leave", "病假"),
    /**
     * marriage_leave
     */
    MARRIAGE_LEAVE("marriage_leave", "婚假"),
    ;

    private String type;
    private String memo;

    LeavePermitEnum(String type, String memo) {
        this.type = type;
        this.memo = memo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
