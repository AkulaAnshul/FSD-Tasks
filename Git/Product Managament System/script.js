function showDescription(product) {
    let description = "";
    switch(product) {
        case "Smartphone":
            description = "A high-end smartphone with advanced features.";
            break;
        case "Laptop":
            description = "A powerful laptop for work and entertainment.";
            break;
        case "Tablet":
            description = "A portable tablet for browsing and media consumption.";
            break;
        case "T-shirt":
            description = "A comfortable cotton t-shirt for everyday wear.";
            break;
        case "Jeans":
            description = "Durable jeans for a classic look.";
            break;
        case "Jacket":
            description = "A warm jacket for cold weather.";
            break;
        default:
            description = "Product details not available.";
    }   
    document.getElementById(product).innerText = description;
    
}