
const int motorPinUno =  8;
const int motorPinDos =  9;
const int motorPinTres =  10;

bool motorUnoActivado = false;
bool motorDosActivado = false;
bool motorTresActivado = false;


char val;

void setup() {
  // set the digital pin as output:
  pinMode(motorPinUno, OUTPUT);
  pinMode(motorPinDos, OUTPUT);
  pinMode(motorPinTres, OUTPUT);
  digitalWrite(motorPinUno, LOW);
  digitalWrite(motorPinDos, LOW);
  digitalWrite(motorPinTres, LOW);
  Serial.begin(9600);
}

void loop() {
  if (Serial.available()) { // If data is available to read,
    val = Serial.read(); // read it and store it in val

    switch (val) {

      case '1':
        if (!motorUnoActivado) {
          digitalWrite(motorPinUno, HIGH);
          Serial.println("encender Motor 1");
        } else {
          digitalWrite(motorPinUno, LOW);
          Serial.println("apagar Motor 1");
        }
        motorUnoActivado = !motorUnoActivado;
        break;

      case '2':
        if (!motorDosActivado) {
          digitalWrite(motorPinDos, HIGH);
          Serial.println("encender Motor 2");
        } else {
          digitalWrite(motorPinDos, LOW);
          Serial.println("apagar Motor 2");
        }
        motorDosActivado = !motorDosActivado;

        break;

      case '3':
        if (!motorTresActivado) {
          digitalWrite(motorPinTres, HIGH);
          Serial.println("encender Motor 3");
        } else {
          digitalWrite(motorPinTres, LOW);
          Serial.println("apagar Motor 3");
        }
        motorTresActivado = !motorTresActivado;

        break;

      case '4':


        break;
    }
  }


  delay(30);

}
