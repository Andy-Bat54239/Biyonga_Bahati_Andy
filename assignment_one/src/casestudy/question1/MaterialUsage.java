package casestudy.question1;

public class MaterialUsage extends ConstructionMaterial{
    public MaterialUsage(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial() {

    }

    @Override
    public void useMaterial() {
        if(getMaterialBalance() - getMaterialQuantity() >= 2){
            setMaterialBalance(getMaterialBalance() - getMaterialQuantity());
            System.out.println("Material used successfully. Remaining Balance: "+ getMaterialBalance()+ " tons");
        }else {
            System.out.println("Error: Not enough material in stock. At least 2 tons must remain");
        }

    }

    @Override
    public void estimateCost() {

    }
}
