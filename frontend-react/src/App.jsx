import { useEffect, useState } from "react";
import { TextField, Button, MenuItem } from "@mui/material";

function App() {
  const [cities, setCities] = useState([]);
  const [fromCity, setFromCity] = useState("");
  const [toCity, setToCity] = useState("");
  const [date, setDate] = useState("");
  const [trips, setTrips] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8000/api/cities")
      .then((response) => response.json())
      .then((data) => setCities(data));
  }, []);

  const searchTrips = () => {
    fetch(
      `http://localhost:8000/api/trips?fromCity=${fromCity}&toCity=${toCity}&date=${date}`
    )
      .then((response) => response.json())
      .then((data) => setTrips(data));
  };

  return (
    <div>
      <h1>Otobüs Bileti Uygulaması</h1>

      <TextField
        select label="Nereden"
        value={fromCity}
        onChange={(e) => setFromCity(e.target.value)}
        sx={{ mr: 2, mb: 2, width: 200 }}
      >
        {cities.map((city) => (
          <MenuItem key={city.id} value={city.name}>
            {city.name}
          </MenuItem>
        ))}
      </TextField>

      <TextField
        select
        label="Nereye"
        value={toCity}
        onChange={(e) => setToCity(e.target.value)}
        sx={{ mr: 2, mb: 2, width: 200 }}
      >
        {cities.map((city) => (
          <MenuItem key={city.id} value={city.name}>
            {city.name}
          </MenuItem>
        ))}
      </TextField>

      <TextField
        type="date"
        value={date}
        onChange={(e) => setDate(e.target.value)}
        sx={{ mr: 2, mb: 2 }}
      />

      <Button
        variant="contained"
        onClick={searchTrips}
        sx={{ mb: 2 }}
      >
        Ara
      </Button>

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
          <hr />
        </div>
      ))}
    </div>
  );
}

export default App;