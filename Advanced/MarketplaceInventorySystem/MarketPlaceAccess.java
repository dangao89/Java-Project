package MarketplaceInventorySystem;

/**
 * The MarketPlaceAccess interface defines common behavior for showing a menu.
 * Classes implementing this interface must provide their own implementation of
 * the showMenu method.
 */
public interface MarketPlaceAccess {

    // Abstract method which will be implemented by the child class to show menu
    public abstract void showMenu();
}
