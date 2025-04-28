package casestudy.question1;

public class CostEstimation extends ConstructionMaterial{
    public CostEstimation(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial() {

    }

    @Override
    public void useMaterial() {

    }

    @Override
    public void estimateCost() {
        double quantity = getMaterialQuantity();
        double costPerTon;
        if (quantity >= 5 && quantity <= 15){
            costPerTon = 200_000;
        } else if (quantity > 15) {
            costPerTon = 180_000;
        }else {
            System.out.println("Error: Material quantity must be at least 5 tons.");
            return;
        }
        double totalCost = costPerTon * quantity;

        System.out.println("=== Cost Estimation ===");
        System.out.println("Contractor ID: "+getContractorId());
        System.out.println("Contractor name: "+ getContractorName());
        System.out.println("Material Quantity used: "+ quantity);
        System.out.printf("Total Cost: %, .2f RWF%n", totalCost);

    }
}
