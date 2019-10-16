CREATE TABLE `restaurants` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(255)
);

CREATE TABLE 'menuItems')(
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `restaurantId` int(11),
    'name' varchar(255),
    'description' varchar(255),
    'price' double(11,2)
);