function Phone(battery, mode, draft, inbox, sent) {
  this.battery = battery;
  this.mode = mode;
  this.draft = draft;
  this.inbox = inbox;
  this.sent = sent;

  this.changeMode = () => {
    if (this.mode) {
      this.mode = false;
    } else {
      if (this.battery > 0) {
        this.mode = true;
      } else {
        this.mode = false;
      }
    }
  };

  this.useBattery = () => {
    this.battery--;
    if (this.battery < 1) {
      this.mode = false;
    }
  };

  this.chargeBattery = (energy) => {
    this.battery += energy;
  };

  this.writeDraft = (draft) => {
    if (this.mode) {
      this.draft = "";
      this.draft += draft;
      this.useBattery();
    }
  };

  this.sendMessage = (phone) => {
    if (this.mode & Boolean(this.draft) & phone.mode) {
      phone.inbox.push(this.draft);
      this.sent.push(this.draft);
      this.draft = "";
      this.useBattery();
      phone.useBattery();
    }
  };

  this.viewInbox = () => {
    if (this.mode) {
      this.useBattery();
      alert(inbox);
    }
  };

  this.viewSent = () => {
    if (this.mode) {
      this.useBattery();
      alert(sent);
    }
  };
}

let apple = new Phone(5, true, "", [], []);
let samsung = new Phone(0, false, "", [], []);
