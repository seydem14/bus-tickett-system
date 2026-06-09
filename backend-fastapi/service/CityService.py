from database import SessionLocal
from model.City import City

def get_cities():
    db = SessionLocal()

    cities = db.query(City).all()

    db.close()

    return cities