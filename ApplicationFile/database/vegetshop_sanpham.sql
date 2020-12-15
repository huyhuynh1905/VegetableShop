-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: vegetshop
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `idsp` int NOT NULL AUTO_INCREMENT,
  `tensp` varchar(40) NOT NULL,
  `giasp` varchar(20) NOT NULL,
  `thuonghieu` varchar(50) DEFAULT 'Đang cập nhật',
  `tinhtrang` varchar(30) DEFAULT 'Còn hàng',
  `khoiluong` varchar(30) DEFAULT NULL,
  `chitiet` text,
  `hinhanh` varchar(250) DEFAULT NULL,
  `nguongoc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idsp`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'Chanh tươi','30000','Đang cập nhật','Còn hàng','1kg/ hộp','Các chuyên gia dinh dưỡng khuyên rằng mỗi ngày bạn hãy uống 1 ly nước chanh tươi ấm pha với mật ong để không ngừng nâng cao sức đề kháng, tăng cường hệ thống miễn dịch và bảo vệ sức khỏe','http://192.168.1.101:8081/images/sp1.jpg','Việt Nam'),(2,'Quả óc chó','430000','Đang cập nhật','Còn hàng','1kg/ hộp','Quả óc chó giúp bà bầu bổ sung các chất dinh dưỡng thiết yếu nhất như Omega-3, Vitamin E, phốt pho và Axit Amin L-Arginne.','http://192.168.1.101:8081/images/sp2.jpg','Mỹ'),(3,'Hạt điều khô','280000','Đang cập nhật','Còn hàng','1kg/ hộp','Nói về sức tác dụng hàng đầu của hạt điều phải kể đến là tác dụng tốt cho tim mạch. Vì hạt điều chứa nhiều chất béo không bão hòa đơn, chất béo này tìm thấy nhiều trong dầu oliu.','http://192.168.1.101:8081/images/sp3.jpg','Việt Nam'),(4,'Hành tây đặc biệt','55000','Đang cập nhật','Còn hàng','1kg/ hộp','Hành không chỉ là thực phẩm rất gần gũi với con người mà nó còn là vị thuốc chữa bệnh rất công hiệu, tốt cho nhóm người mắc bệnh về đường hô hấp, bệnh hen suyễn, chữa chứng mất ngủ và làm giảm cholesterol.','http://192.168.1.101:8081/images/sp4.jpg','Việt Nam'),(5,'Súp lơ trắng','20000','Đang cập nhật','Còn hàng','1kg/ hộp','Súp lơ có chứa các thành phần như: Protein 3,5%; gluxit 4,9%; và nhiều khoáng chất, vitamin như: can-xi (26 mg%); phốtpho (51 mg%)','http://192.168.1.101:8081/images/sp5.jpg','Việt Nam'),(6,'Nho mỹ nhập khẩu','2350000','Đang cập nhật','Còn hàng','1kg/ hộp','Nho Mỹ được biết đến là một trong những loại trái cây được ưa chuộng nhất trên thế giới với vẻ căng trong mọng nước và vị ngọt thanh đặc trưng.','http://192.168.1.101:8081/images/sp6.jpg','Mỹ'),(7,'Rau cải bẹ xanh non','20000','Đang cập nhật','Còn hàng','1 Bó','Thông tin sản phẩm đang cập nhật','http://192.168.1.101:8081/images/sp7.jpg','Việt Nam'),(8,'Dưa lưới nhập khẩu Thái Lan','90000','Đang cập nhật','Còn hàng','1 trái','Thông tin sản phẩm đang cập nhật','http://192.168.1.101:8081/images/sp8.jpg','Thái Lan'),(9,'Vải thiều Thanh Hà','40000','Đang cập nhật','Còn hàng','1kg /hộp','Mùa hè là thời gian lý tưởng để nhâm nhi nhiều loại trái cây và vải nằm trong số những trái ngon và bổ không thể bỏ qua.','http://192.168.1.101:8081/images/sp9.jpg','Việt Nam'),(10,'Đào đỏ Mỹ','31000','Đang cập nhật','Còn hàng','1kg /hộp','Thông tin sản phẩm đang cập nhật','http://192.168.1.101:8081/images/sp10.jpg','Mỹ'),(11,'Dâu tây Đà Lạt','350000','Đang cập nhật','Còn hàng','1kg /hộp','Dâu tây nói chung và dâu tây Đà Lạt nói riêng, từ lâu được biết tới là một loại trái cây rất tốt cho con người.','http://192.168.1.101:8081/images/sp11.jpg','Việt Nam'),(12,'Táo xanh Mỹ','160000','Đang cập nhật','Còn hàng','1kg /hộp','Táo là loại cây ưa khí hậu khô, nóng và ít côn trùng và dịch bệnh. Táo GrannySmith (Táo Xanh) có nguồn gốc từ Úc du nhập vào Mỹ năm 1868. Táo có màu xanh lá, vị chua đậm, rất giòn, nhiều nước.','http://192.168.1.101:8081/images/sp12.jpg','Mỹ'),(13,'Lê xanh Mỹ','230000','Đang cập nhật','Còn hàng','1kg /hộp','Theo phân tích khoa học, quả lê chứa protein, lipid, cenlulose, canxi, phốt pho, sắt, caroten, vitamin B1, B2, C, đường gluco, axít acetic...','http://192.168.1.101:8081/images/sp13.jpg','Mỹ'),(14,'Cam Navel ruột vàng','240000','Đang cập nhật','Còn hàng','1kg /hộp','Cam Navel ruột vàng Úc vỏ màu vàng, ruột màu vàng đậm, vị ngọt thanh, không hạt, mọng nước. Thường dùng để ăn chứ không ép nước. Nên chọn quả sáng màu, da mịn, tròn trịa, cầm nặng tay.','http://192.168.1.101:8081/images/sp14.jpg','Úc'),(15,'Hạt điều trắng','380000','Đang cập nhật','Còn hàng','1kg /hộp','Nói về sức tác dụng hàng đầu của hạt điều phải kể đến là tác dụng tốt cho tim mạch. Vì hạt điều chứa nhiều chất béo không bão hòa đơn, chất béo này tìm thấy nhiều trong dầu oliu.','http://192.168.1.101:8081/images/sp15.jpg','Việt Nam'),(16,'Cá hồi Mỹ','600000','Mipec','Còn hàng','Phần','Thông tin sản phẩm đang cập nhật.','http://192.168.1.101:8081/images/sp16.jpg','Mỹ'),(17,'Tôm biển','300000','Vinmart','Còn hàng','Khẩu phần','Thông tin sản phẩm đang cập nhật.','http://192.168.1.101:8081/images/sp17.jpg','Việt Nam'),(18,'Mực Thanh Hóa','70000','Mipec','Còn hàng','Phần','Thông tin sản phẩm đang cập nhật.','http://192.168.1.101:8081/images/sp18.jpg','Việt Nam'),(19,'Cua bể','250000','Vinmart','Còn hàng','Phần','Thông tin sản phẩm đang cập nhật.','http://192.168.1.101:8081/images/sp19.jpg','Việt Nam'),(20,'Cá hồi','1200000','Tmart','Còn hàng','Phần','Thông tin sản phẩm đang cập nhật.','http://192.168.1.101:8081/images/sp20.jpg','Mỹ'),(21,'Hạt hạnh nhân','320000','Đang cập nhật','Còn hàng','1Kg /hộp','Hạnh nhân rất tốt cho những người phòng ngừa các vấn đề về hàm lượng glucose và cholesterol. Thành phần trong hạt hạnh nhân giúp điều chỉnh, cân bằng 2 chất này, giúp phòng ngừa tiểu đường, mỡ máu, béo phì, thừa cân.','http://192.168.1.101:8081/images/sp21.jpg','Việt Nam'),(22,'Thịt bò thăn','460000','Đang cập nhật','Còn hàng','1kg','Thông tin sản phẩm đang cập nhật','http://192.168.1.101:8081/images/sp22.jpg','Việt Nam'),(23,'Thịt bò Canada nhập khẩu','40000','Đang cập nhật','Còn hàng','1kg','Thông tin sản phẩm đang cập nhật','http://192.168.1.101:8081/images/sp23.jpg','Cannada'),(24,'Thịt bò Mỹ','365000','Đang cập nhật','Còn hàng','1kg','Thông tin sản phẩm đang cập nhật','http://192.168.1.101:8081/images/sp24.jpg','Mỹ'),(25,'Thịt lợn nạc vai','65000','Đang cập nhật','Còn hàng','1kg','Thông tin sản phẩm đang cập nhật','http://192.168.1.101:8081/images/sp25.jpg','Việt Nam'),(26,'Sườn lợn Brazil','200000','Đang cập nhật','Còn hàng','1kg','Thông tin sản phẩm đang cập nhật','http://192.168.1.101:8081/images/sp26.jpg','Brazil'),(27,'Ba chỉ bò Mỹ','500000','Tmart','Còn hàng','1kg','Thông tin sản phẩm đang cập nhật','http://192.168.1.101:8081/images/sp27.jpg','Mỹ');
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-15 16:18:40
