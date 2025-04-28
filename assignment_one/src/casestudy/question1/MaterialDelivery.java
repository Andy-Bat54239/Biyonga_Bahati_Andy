package casestudy.question1;

public class MaterialDelivery extends ConstructionMaterial{

    public MaterialDelivery(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial() {
        if (getMaterialQuantity() >= 1 && getMaterialQuantity() <= 10) {
            setMaterialBalance(getMaterialBalance() + getMaterialQuantity());
            System.out.println("Delivery Successful. New Material Balance: "+ getMaterialBalance() + " tons");
        }else {
            System.out.println("Error: Material quantity must be between 1 and 10 tons");
        }

    }

    @Override
    public void useMaterial() {

    }

    @Override
    public void estimateCost() {

    }
}
