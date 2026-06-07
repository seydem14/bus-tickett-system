import { useEffect,useState } from "react";
function App(){ //bileşen yani component ekranda ne gösterileceğini söyleyen fonk

    const[cities,setCities]=useState([]); //stateler sayfada değişebilen veriler burada setCities veriyi değiştirmeye yarıyor
    //başta cities[]içi boş backendten veri gelince setCities(data) oluyo 
    //
    const[fromCity,setFromCity]=useState("");
    const[toCity,setToCity]=useState("");
    const[date,setDate]=useState("");
    const[trips,setTrips]=useState([]); // setTrips(data) aşağıda var backendden gelen seferleri trips değişkenine koyuyor

 useEffect(() => {
  fetch("http://localhost:8080/api/cities")
  .then((response) => response.json())
  .then((data)=>setCities(data));
},[]);

const searchTrips=()=>{
    fetch(
        `http://localhost:8080/api/trips?fromCity=${fromCity}&toCity=${toCity}&date=${date}`
         )
        .then((response) => response.json()) //backendden gelen responseyu js nesnesine çeviriyor
        .then((data) => setTrips(data));
    
};

return(

    <div>

        <h1>Otobüs Bileti Uyg</h1>

        <select value={fromCity} onChange={(e) => setFromCity(e.target.value)}>
          <option value="">Nereden</option>
          {cities.map((city)=>(

            <option key={city.id}  value={city.name}>
                {city.name}
            </option>


          ))}
          </select>

          <select value={toCity} onChange={(e) => setToCity(e.target.value)}>
          <option value="">Nereye</option>
          {cities.map((city)=>(

            <option key={city.id}  value={city.name}>
                {city.name}
            
            </option>
          ))}
          
        </select>


        <input
            type="date"
            value={date}
            onChange={(e) => setDate(e.target.value)}
        />

        <button onClick={searchTrips}>Ara</button>

        <h2>Seferler</h2>

        {trips.map((trip) => (
            <div key={trip.id}>
              <p>
                {trip.fromCity} → {trip.toCity}
              </p>
               <p>Firma: {trip.companyName}</p>
              <p>Tarih: {trip.date}</p>
              <p>Saat: {trip.time}</p>
              <p>Fiyat: {trip.price} TL</p>
            </div>
        ))}



          


    </div>

    
    




)

}
export default App;