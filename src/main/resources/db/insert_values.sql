INSERT INTO `TR_CATEGORY`
    (`NAME`)
VALUES
    ('Electronics'),
    ('Books'),
    ('Computers');

INSERT INTO `TR_PRODUCT`
    (`NAME`, `DESCRIPTION`, `PRICE`)
VALUES
    ('The Lord of the Rings', 'Lorem ipsum dolor dit amet.', 90.5),
    ('SmartTV', 'Nulla eu imperdiet purus.', 2190.0),
    ('MacBookPro', 'Nam eleifend maximus tortor, at mollis', 1250.0),
    ('PC Gamer', 'Nam eleifend maximus tortor, at mollis', 4250.0),
    ('Rails for Dummies', 'Nam eleifend maximus tortor, at mollis', 100.99);

INSERT INTO `TR_CLIENT`
	(`NAME`, `EMAIL`, `PHONE`, `PASSWORD`)
VALUES
	('Maria Brown', 'maria@gmail.com', '988880000', '123456'),
    ('Alex Green', 'alex@gmail.com', '977776666', '123456');

INSERT INTO `TR_ORDER`
	(`MOMENT`, `ORDER_STATUS`, `CLIENT_ID`)
VALUES
	('2019-06-20 19:53:07', 2, 1),
    ('2019-07-21 03:42:10', 1, 2),
    ('2019-07-22 15:21:22', 1, 1);

INSERT INTO `TR_PAYMENT`
	(`MOMENT`, `ORDER_ID`)
VALUES
	('2019-06-20 13:02:55', 1);

INSERT INTO `TR_ORDER_ITEM`
	(`QUANTITY`, `PRICE`, `PRODUCT_ID`, `ORDER_ID`)
VALUES
	(2, 90.5, 1, 1),
    (1, 1250.0, 3, 1),
    (2, 1250.0, 3, 2),
    (2, 100.99, 4, 3);