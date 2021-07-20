package za.co.labournet.tax;

public enum MedicalAidMemberKey {
	
	MAIN(0),
	SECONDARY(1),
	ANY(2);
	
	private final int memberKey;
	
	MedicalAidMemberKey(int memberKey) {
        this.memberKey = memberKey;
    }
    public int getMemberKey() {
        return this.memberKey;
    }
}
