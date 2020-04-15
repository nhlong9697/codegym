function Apple(weight) {
  this.weight = weight;

  this.decrease = () => {
    this.weight--;
  };

  this.isEmpty = () => {
    if (this.weight == 0) {
      return true;
    }
    return false;
  };

  this.getWeight = () => {
    return this.weight;
  };
}

function Human(name, gender, weight) {
  this.name = name;
  this.gender = gender;
  this.weight = weight;

  this.isMale = () => {
    if (this.gender) {
      return true;
    }
    return false;
  };

  this.setGender = (gender) => {
    this.gender = gender;
  };

  this.checkApple = (apple) => {
    return apple.isEmpty();
  };

  this.eatApple = (apple) => {
    if (this.checkApple(apple)) {
      apple.decrease();
      this.weight++;
    } else {
      say("This apple is finished");
    }
  };

  this.say = (sentence) => {
    alert(sentence);
  };

  this.getName = () => {
    return this.name;
  };

  this.setName = (name) => {
    this.name = name;
  };

  this.getWeight = () => {
    return this.weight;
  };

  this.setWeight = (weight) => {
    this.weight = weight;
  };
}
