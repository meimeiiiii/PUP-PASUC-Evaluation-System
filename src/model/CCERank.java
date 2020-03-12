package model;

public class CCERank {
	private String rankId;
	private String rankName;
	private int ptsMin;
	private int ptsMax;
	
	public String getRankId() {
		return rankId;
	}
	public void setRankId(String rankId) {
		this.rankId = rankId;
	}
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	public int getPtsMin() {
		return ptsMin;
	}
	public void setPtsMin(int ptsMin) {
		this.ptsMin = ptsMin;
	}
	public int getPtsMax() {
		return ptsMax;
	}
	public void setPtsMax(int ptsMax) {
		this.ptsMax = ptsMax;
	}
}
