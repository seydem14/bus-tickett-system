from sqlalchemy import Column, Integer, String, Date
from database import Base

class Trip(Base):
    __tablename__ = "trips"

    id = Column(Integer, primary_key=True, index=True)
    from_city = Column(String)
    to_city = Column(String)
    date = Column(Date)
    price = Column(Integer)