CREATE TABLE `user`
(
    `id`         integer     NOT NULL AUTO_INCREMENT,
    `first_name` varchar(20) NOT NULL,
    `last_name`  varchar(15) NOT NULL,
    `is_active`  boolean     NOT NULL DEFAULT TRUE, /* Soft delete */
    PRIMARY KEY (`id`)
);

INSERT INTO `user`(`id`, `first_name`, `last_name`)
VALUES (1, 'Taha', 'Abbas');