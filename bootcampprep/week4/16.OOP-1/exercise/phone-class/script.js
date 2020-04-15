function Phone(battery, mode, phoneNumber) {
  this.phoneNumber = phoneNumber;
  this.battery = battery;
  this.inbox = [];
  this.draft = [];
  this.sent = [];
  this.mode = mode;

  this.changeMode = (mode) => {
    this.mode = mode;
  };
  this.chargeBattery = (energy) => {
    this.battery += energy;
  };
  this.writeDraft = (draft) => {
    if (this.mode) {
      this.draft.push(draft);
      this.battery--;
    }
  };
  this.sendMessage = (draft, phoneNumber) => {
    if (this.mode) {
      phoneNumber.inbox.push(draft);
      this.sent.inbox.push(draft);
      this.battery--;
    }
  };
  this.viewInbox = () => {
    if (this.mode) {
      this.battery--;
      return this.inbox;
    }
  };
  this.viewSent = () => {
    if (this.mode) {
      this.battery--;
      return this.sent;
    }
  };
}

let apple = Phone(90, true, 1);
let samsung = Phone(100, false, 2);

apple.sendMessage("test message", 2);
samsung.viewInbox();
