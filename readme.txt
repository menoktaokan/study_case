Bu proje 5 farklı micro service'in birleşiminden oluşmaktadır. Bunlar:
-Bayi bilgilerinin girilebileceği API
-Ürün bilgilerinin girilebileceği API
-Bayilerde satılabilecek ürünlerin tanımlanabileceği bir API
-Hangi bayide hangi ürünlerin satılabildiğini raporlayan bir API
-Ve tüm bu API'lerin işlerimlerini tek bir elden gerçekleştiren İşlem Merkezi API.

Projede in memory db olarak H2 kullanışmıştır.

Projenin hizmet adresleri:

http://localhost:8091/bayi_kaydet
	örnek: (POST)
	  	{
        "name":"Buyaka",
        "productTypes":["IT"]
    	}
    
http://localhost:8092/{bayiAdi}/urunler

http://localhost:8093/bayi_urun_tanimla/{bayiAdi}/urun_ekle
	örnek: (PUT)
	"Home"
	
http://localhost:8094/urun_kaydet
	örnek: (POST)
	    {
        "name":"Klavye",
        "price":225,
        "type":"Tech"
    	}