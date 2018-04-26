package fr.lcdlv.promo05.covers;

class Cover {

  private final DietType dietType;

  public Cover(DietType dietType) {
    this.dietType = dietType;
  }

  public DietType getDietType() {
    return this.dietType;
  }
}
