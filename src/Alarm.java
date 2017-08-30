import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Alarm {
 String HistoryAction,AlarmKey,Node,SubMethod,
 AlarmGroup,SubAlarmGroup;
	int AlarmType,Severity;
	long AlarmId, Reported;
	public Alarm() {}
	
	public Alarm(String historyAction, String alarmKey, String node, String subMethod, String alarmGroup,
			String subAlarmGroup, int alarmType, int severity, long alarmId, long reported) {
		this.setHistoryAction(historyAction);
		this.setAlarmKey(alarmKey);
		this.setNode(node);
		this.setSubMethod(subMethod);
		this.setAlarmGroup(subAlarmGroup);
		this.setSubAlarmGroup(subAlarmGroup);
		this.setAlarmType(alarmType);
		this.setSeverity(severity);
		this.setAlarmId(alarmId);
		this.setReported(reported);
		

	}
	public String getHistoryAction() {
		return HistoryAction;
	}
	public void setHistoryAction(String historyAction) {
		HistoryAction = historyAction;
	}
	public String getAlarmKey() {
		return AlarmKey;
	}
	public void setAlarmKey(String alarmKey) {
		AlarmKey = alarmKey;
	}
	public String getNode() {
		return Node;
	}
	public void setNode(String node) {
		Node = node;
	}
	public String getSubMethod() {
		return SubMethod;
	}
	public void setSubMethod(String subMethod) {
		SubMethod = subMethod;
	}
	public String getAlarmGroup() {
		return AlarmGroup;
	}
	public void setAlarmGroup(String alarmGroup) {
		AlarmGroup = alarmGroup;
	}
	public String getSubAlarmGroup() {
		return SubAlarmGroup;
	}
	public void setSubAlarmGroup(String subAlarmGroup) {
		SubAlarmGroup = subAlarmGroup;
	}
	public int getAlarmType() {
		return AlarmType;
	}
	public void setAlarmType(int alarmType) {
		AlarmType = alarmType;
	}
	public int getSeverity() {
		return Severity;
	}
	public void setSeverity(int severity) {
		Severity = severity;
	}
	public long getAlarmId() {
		return AlarmId;
	}
	public void setAlarmId(long alarmId) {
		AlarmId = alarmId;
	}
	public long getReported() {
		return Reported;
	}
	public void setReported(long reported) {
		Reported = reported;
	}

	@Override
	public String toString() {
		 DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm:ss.SSSS");
		 DateTime stamp = new DateTime(Reported);
		
		return "Alarm [ AlarmId= " + AlarmId+ ", HistoryAction=" + HistoryAction + ", AlarmKey=" 
		+ AlarmKey + ", Node=" + Node + ", SubMethod="
				+ SubMethod + ", AlarmGroup=" + AlarmGroup 
				+ ", SubAlarmGroup=" + SubAlarmGroup + ", AlarmType="
				+ AlarmType + ", Severity=" + Severity  + ", Reported=" + Reported +  " " +fmt.print(stamp)+ " ]";
	}
	
	
	
}
