--
-- Database: `final-project`
--

-- --------------------------------------------------------

--
-- Table structure for table `catalogue`
--

CREATE TABLE `catalogue` (
  `מספר סידורי` int(10) NOT NULL,
  `חברה` varchar(10) NOT NULL,
  `שם` varchar(10) NOT NULL,
  `קישור` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `catalogue`
--

INSERT INTO `catalogue` (`מספר סידורי`, `חברה`, `שם`, `קישור`) VALUES
(1, 'קליל', 'קלאסי', 'clasic'),
(2, 'קליל', 'בלגי', 'blge'),
(3, 'קליל', 'אופיס', 'ofice'),
(4, 'אקסטל', 'בלגי', 'blge');

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE `contacts` (
  `מספר זהות` int(11) NOT NULL,
  `שם` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `משפחה` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `כתובת` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `טלפון` int(11) NOT NULL,
  `דואר אלקטרוני` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`מספר זהות`, `שם`, `משפחה`, `כתובת`, `טלפון`, `דואר אלקטרוני`) VALUES
(1, 'monder', 'ashkar', 'deir hana', 520002001, 'monder@mondercompany.com'),
(3, 'חסאם', 'חטיב', 'דיר חנא', 509363830, 'hosam.kh@live.com'),
(4, '1', '1', '', 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `customersdebts`
--

CREATE TABLE `customersdebts` (
  `מספר חוב` int(11) NOT NULL,
  `שם לקוח` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `תאריך` date NOT NULL,
  `חוב` int(11) NOT NULL,
  `שולם` int(11) NOT NULL,
  `לתשלום` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customersdebts`
--

INSERT INTO `customersdebts` (`מספר חוב`, `שם לקוח`, `תאריך`, `חוב`, `שולם`, `לתשלום`) VALUES
(1, 'monder', '2017-02-08', 123, 324, -201),
(2, 'מונדר', '2017-02-08', 5000, 0, 0),
(3, 'hosam', '2017-02-08', 6000, 0, 0),
(4, '1', '2017-02-08', 1, 1501, -1500),
(5, 'חוסאם', '2017-02-08', 8000, 1060, 6940),
(6, 'monder', '2017-02-11', 5000, 3111, 1889);

-- --------------------------------------------------------

--
-- Table structure for table `customersdebtspaied`
--

CREATE TABLE `customersdebtspaied` (
  `מספר חוב` int(10) NOT NULL,
  `מספר תשלום` int(10) NOT NULL,
  `תאריך` varchar(10) NOT NULL,
  `סוג תשלום` varchar(10) NOT NULL,
  `סכום` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customersdebtspaied`
--

INSERT INTO `customersdebtspaied` (`מספר חוב`, `מספר תשלום`, `תאריך`, `סוג תשלום`, `סכום`) VALUES
(4, 26, '2017-02-08', 'visa', 1000),
(4, 27, '2017-02-08', 'visa', 1),
(5, 28, '2017-02-08', 'asd', 2),
(5, 29, '2017-02-08', 'visa', 998),
(5, 30, '2017-02-08', 'visa', 50),
(5, 31, '2017-02-08', 'sd', 10),
(6, 32, '2017-02-11', 'visa', 1000),
(6, 33, '2017-02-11', 'שיק', 2000),
(6, 34, '2017-02-11', 'שיק', 100),
(6, 35, '2017-02-11', 'שיק', 10),
(6, 36, '2017-02-11', 'ויזה', 1),
(1, 37, '2017-04-24', 'm', 100),
(1, 38, '2017-04-24', '100100', 100),
(4, 41, '2017-06-02', 'visa', 500),
(1, 42, '2017-06-02', '1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `debtsforsuppliers`
--

CREATE TABLE `debtsforsuppliers` (
  `מספר חוב` int(11) NOT NULL,
  `שם ספק` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `תאריך` date NOT NULL,
  `חוב` int(11) NOT NULL,
  `שולם` int(11) NOT NULL,
  `לתשלום` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `debtsforsuppliers`
--

INSERT INTO `debtsforsuppliers` (`מספר חוב`, `שם ספק`, `תאריך`, `חוב`, `שולם`, `לתשלום`) VALUES
(9, '1', '2017-05-30', 1, 0, 0),
(10, 'dssdsd', '2017-05-30', 2, 0, 0),
(12, '2', '2017-05-30', 100, 243, -143),
(13, 'ss', '2017-05-30', 145, 23223, -23078),
(14, '1', '2017-05-30', 1, 1, 0),
(15, 'monder', '2017-06-04', 100, -40, 140);

-- --------------------------------------------------------

--
-- Table structure for table `debtsforsupplierspaied`
--

CREATE TABLE `debtsforsupplierspaied` (
  `מספר חוב` int(10) NOT NULL,
  `מספר תשלום` int(10) NOT NULL,
  `תאריך` varchar(10) NOT NULL,
  `סוג תשלום` varchar(10) NOT NULL,
  `סכום` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `debtsforsupplierspaied`
--

INSERT INTO `debtsforsupplierspaied` (`מספר חוב`, `מספר תשלום`, `תאריך`, `סוג תשלום`, `סכום`) VALUES
(12, 8, '2017-05-30', 'sds', 10),
(12, 9, '2017-05-30', 's', 2),
(12, 10, '2017-05-30', 's', 222),
(12, 11, '2017-05-30', '1', 1),
(12, 12, '2017-05-30', '1', 1),
(12, 13, '2017-05-30', '1', 1),
(12, 14, '2017-05-30', '1', 1),
(13, 16, '2017-05-30', '1', 1),
(13, 17, '2017-06-01', '323', 23222),
(14, 18, '2017-06-04', '1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `generalreminders`
--

CREATE TABLE `generalreminders` (
  `מספר תזכורת` int(3) NOT NULL,
  `תזכורת` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `generalreminders`
--

INSERT INTO `generalreminders` (`מספר תזכורת`, `תזכורת`) VALUES
(1, 'צריך להכרכיב ליוסי'),
(2, 'צריך להתחיל בפרויקט מונדר'),
(3, 'יש להזמין זכוכית'),
(4, 'חסר לי פרופילים'),
(5, '1'),
(6, '1'),
(10, '1'),
(11, '11'),
(12, '11'),
(13, '222222'),
(14, '1'),
(15, '1'),
(19, 'vjfj');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `מספר הזמנה` int(10) NOT NULL,
  `שם ספק` varchar(30) NOT NULL,
  `תאריך` date NOT NULL,
  `אתר` varchar(30) NOT NULL,
  `סוג` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`מספר הזמנה`, `שם ספק`, `תאריך`, `אתר`, `סוג`) VALUES
(1, 'MSI', '2017-02-01', 'דיר חנא', 'הזמנת זכוכית'),
(2, 'MSI', '2017-02-08', 'חיפה', 'הזמנת זכוכית'),
(6, '1', '2017-02-10', '1', 'debtsForSuppliers'),
(7, '2', '2017-02-10', '2', 'debtsForSuppliers'),
(10, 'צםצ', '2017-02-11', 'צםמגקר', 'debtsForSuppliers'),
(11, '1', '2017-05-27', '1', 'הזמנת פירזול'),
(12, '1', '2017-05-29', '1', 'הזמנת פרופילים'),
(13, '1', '2017-06-04', '1', 'הזמנת תריס גלילה');

-- --------------------------------------------------------

--
-- Table structure for table `ordersproducts`
--

CREATE TABLE `ordersproducts` (
  `מספר סידורי` int(11) NOT NULL,
  `מספר הזמנה` int(11) NOT NULL,
  `מספר מוצר` int(50) NOT NULL,
  `תיאור` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `רוחב` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `גובה` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `כמות` int(11) NOT NULL,
  `הערות` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ordersproducts`
--

INSERT INTO `ordersproducts` (`מספר סידורי`, `מספר הזמנה`, `מספר מוצר`, `תיאור`, `רוחב`, `גובה`, `כמות`, `הערות`) VALUES
(7, 2, 1, '1', '1', '1', 1, '1	'),
(10, 2, 2, '2', '2', '2', 2, '2'),
(14, 9, 1, '2', '2', '2', 2, '2'),
(15, 10, 1, '1', '1', '1', 1, '1'),
(16, 1, 1, '14646', '44', '44', 41, 'gjgj'),
(17, 6, 1, '1', '1', '11', 1, '1');

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE `projects` (
  `מספר פרויקט` int(11) NOT NULL,
  `איש קשר` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `אתר` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `שם מזמין` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `צבע` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `מחיר צבע` int(50) NOT NULL,
  `זיגוג` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `מחיר זיגוג` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`מספר פרויקט`, `איש קשר`, `אתר`, `שם מזמין`, `צבע`, `מחיר צבע`, `זיגוג`, `מחיר זיגוג`) VALUES
(1, 'מונדר', 'דיר חנא', 'מונדר אשקר', 'צבע איירון', 40, 'זכוכית בידודית שקופה 4+6+4', 40),
(2, 'monder', '', '', '', 30, '', 40);

-- --------------------------------------------------------

--
-- Table structure for table `projectsproducts`
--

CREATE TABLE `projectsproducts` (
  `מספר סידורי` int(11) NOT NULL,
  `מספר פרויקט` int(11) NOT NULL,
  `מספר מוצר` int(11) NOT NULL,
  `קוד מוצר` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `תיאור` varchar(220) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `סדרה` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `רוחב` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `גובה` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `כמות` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `מידת קבוע` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `מחיר` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `projectsproducts`
--

INSERT INTO `projectsproducts` (`מספר סידורי`, `מספר פרויקט`, `מספר מוצר`, `קוד מוצר`, `תיאור`, `סדרה`, `רוחב`, `גובה`, `כמות`, `מידת קבוע`, `מחיר`) VALUES
(7, 1, 1, '5000', 'דלת הזזה 2 כנפיים + רשת 7300,ללא שפרוצים עם קבוע עליון \r\nזכוכית אנטיסן 4 מ"ם \r\nתריס גלילה - מוקצף - איירון \r\nעם מנוע\r\nכולל ארגז סמוי', '7300', '2000', '2000', '1', '300', '7358'),
(8, 1, 2, '23', 'חלון 2 כנפיים + רשת קטנה חדשה \r\nזכוכית אנטיסן 4 מ"ם \r\nתריס גלילה - מוקצף - איירון \r\nעם מנוע\r\nכולל ארגז סמוי', '1700', '1500', '1500', '3', '300', '3549');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `מספר מזהה` int(11) NOT NULL,
  `שם` varchar(20) NOT NULL,
  `מיקום` varchar(20) NOT NULL,
  `טלפון` int(11) NOT NULL,
  `פקס` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `catalogue`
--
ALTER TABLE `catalogue`
  ADD PRIMARY KEY (`מספר סידורי`);

--
-- Indexes for table `contacts`
--
ALTER TABLE `contacts`
  ADD PRIMARY KEY (`מספר זהות`);

--
-- Indexes for table `customersdebts`
--
ALTER TABLE `customersdebts`
  ADD PRIMARY KEY (`מספר חוב`);

--
-- Indexes for table `customersdebtspaied`
--
ALTER TABLE `customersdebtspaied`
  ADD PRIMARY KEY (`מספר תשלום`);

--
-- Indexes for table `debtsforsuppliers`
--
ALTER TABLE `debtsforsuppliers`
  ADD PRIMARY KEY (`מספר חוב`);

--
-- Indexes for table `debtsforsupplierspaied`
--
ALTER TABLE `debtsforsupplierspaied`
  ADD PRIMARY KEY (`מספר תשלום`);

--
-- Indexes for table `generalreminders`
--
ALTER TABLE `generalreminders`
  ADD PRIMARY KEY (`מספר תזכורת`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`מספר הזמנה`);

--
-- Indexes for table `ordersproducts`
--
ALTER TABLE `ordersproducts`
  ADD PRIMARY KEY (`מספר סידורי`);

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`מספר פרויקט`);

--
-- Indexes for table `projectsproducts`
--
ALTER TABLE `projectsproducts`
  ADD PRIMARY KEY (`מספר סידורי`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`מספר מזהה`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `catalogue`
--
ALTER TABLE `catalogue`
  MODIFY `מספר סידורי` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `contacts`
--
ALTER TABLE `contacts`
  MODIFY `מספר זהות` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `customersdebts`
--
ALTER TABLE `customersdebts`
  MODIFY `מספר חוב` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `customersdebtspaied`
--
ALTER TABLE `customersdebtspaied`
  MODIFY `מספר תשלום` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;
--
-- AUTO_INCREMENT for table `debtsforsuppliers`
--
ALTER TABLE `debtsforsuppliers`
  MODIFY `מספר חוב` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `debtsforsupplierspaied`
--
ALTER TABLE `debtsforsupplierspaied`
  MODIFY `מספר תשלום` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `generalreminders`
--
ALTER TABLE `generalreminders`
  MODIFY `מספר תזכורת` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `מספר הזמנה` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `ordersproducts`
--
ALTER TABLE `ordersproducts`
  MODIFY `מספר סידורי` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `projects`
--
ALTER TABLE `projects`
  MODIFY `מספר פרויקט` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `projectsproducts`
--
ALTER TABLE `projectsproducts`
  MODIFY `מספר סידורי` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `מספר מזהה` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
