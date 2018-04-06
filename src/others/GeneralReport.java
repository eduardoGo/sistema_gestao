package others;

public class GeneralReport {
	
	private int resourceFree=0;
	private int resourceAllocated=0;
	private int resourceInProcess=0;
	private int allocations=0;
	
	
	public GeneralReport(int resourceFree) {
		
		this.resourceFree = resourceFree;
	}
	
	
	public void addResourceFree(int resourceFree) {
		this.resourceFree += resourceFree;
	}
	
	public void addResourceAllocated(int resourceAllocated) {
		this.resourceAllocated += resourceAllocated;
	}
	
	public void addResourceInProcess(int resourceInProcess) {
		this.resourceInProcess += resourceInProcess;
	}
	
	public void addAllocations(int allocations) {
		this.allocations += allocations;
	}


	public String toString() {
		return "GeneralReport [ResourceFree: " + resourceFree
				+ ", ResourceAllocated: " + resourceAllocated
				+ ", ResourceInProcess: " + resourceInProcess + ", Allocations: "
				+ allocations + "]";
	}
	
	
}
