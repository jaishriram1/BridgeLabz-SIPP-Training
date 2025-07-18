import java.util.Stack;

public class BrowserNavigation {

    public static void main(String[] args) {
        System.out.println("🚀 Initializing Browser Navigation...");
        NavigationManager browser = new DesktopNavigationManager("https://www.google.com");
        System.out.println("Current Page: " + browser.getCurrentUrl());

        System.out.println("\nVisiting new pages...");
        browser.visit("https://github.com");
        System.out.println("Current Page: " + browser.getCurrentUrl());

        browser.visit("https://stackoverflow.com");
        System.out.println("Current Page: " + browser.getCurrentUrl());

        System.out.println("\nNavigating back...");
        browser.goBack();
        System.out.println("Current Page: " + browser.getCurrentUrl());
        browser.goBack();
        System.out.println("Current Page: " + browser.getCurrentUrl());

        System.out.println("\nNavigating forward...");
        browser.goForward();
        System.out.println("Current Page: " + browser.getCurrentUrl());

        System.out.println("\nVisiting a new page from the middle of history...");
        browser.visit("https://leetcode.com");
        System.out.println("Current Page: " + browser.getCurrentUrl());
        
        System.out.println("\nAttempting to go forward...");
        browser.goForward(); 
        System.out.println("Current Page: " + browser.getCurrentUrl());
    }
}

// ---

interface NavigationManager {
    void visit(String url);
    String goBack();
    String goForward();
    String getCurrentUrl();
}

// ---

class DesktopNavigationManager implements NavigationManager {
    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentUrl;

    public DesktopNavigationManager(String homePage) {
        this.backStack = new Stack<>();
        this.forwardStack = new Stack<>();
        this.currentUrl = homePage;
    }

    @Override
    public void visit(String url) {
        backStack.push(this.currentUrl);
        this.currentUrl = url;
        forwardStack.clear();
    }

    @Override
    public String goBack() {
        if (!backStack.isEmpty()) {
            forwardStack.push(this.currentUrl);
            this.currentUrl = backStack.pop();
        }
        return this.currentUrl;
    }

    @Override
    public String goForward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(this.currentUrl);
            this.currentUrl = forwardStack.pop();
        }
        return this.currentUrl;
    }
    
    @Override
    public String getCurrentUrl() {
        return this.currentUrl;
    }
}