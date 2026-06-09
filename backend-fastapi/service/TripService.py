from database import SessionLocal
from model.Trip import Trip

def search_trips(fromCity: str, toCity: str, date: str):
    db = SessionLocal()

    trips = db.query(Trip).filter(
        Trip.from_city == fromCity,
        Trip.to_city == toCity,
        Trip.date == date
    ).all()

    db.close()

    return trips