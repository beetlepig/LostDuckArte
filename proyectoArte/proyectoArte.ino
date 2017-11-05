
const int motorPinUno =  8;
const int motorPinDos =  9;
const int motorPinTres =  10;

bool motorUnoActivado = false;
bool motorDosActivado = false;
bool motorTresActivado = false;

unsigned long previousMillis = 0;       

// constants won't change:
const long interval = 10;         


String val;

String part01;

String part02;

bool playerOneUp;

void setup() {
  // set the digital pin as output:
  pinMode(motorPinUno, OUTPUT);
  pinMode(motorPinDos, OUTPUT);
  pinMode(motorPinTres, OUTPUT);
  digitalWrite(motorPinUno, LOW);
  digitalWrite(motorPinDos, LOW);
  digitalWrite(motorPinTres, LOW);
  Serial.begin(9600);
  Serial.setTimeout(50);
}

void loop() {
  unsigned long currentMillis = millis();

    if (currentMillis - previousMillis >= interval) {
        previousMillis = currentMillis;


        
  if (Serial.available()) { // If data is available to read,
    delay(2);
   val= Serial.readStringUntil(',');// read the incoming data as string
   // Serial.println(val); 
    part01 = getValue(val,':',0);
    
    if(part01 == "playerOneUp"){
      
    part02 = getValue(val,':',1);
    
    if(part02 == "true"){
      playerOneUp = true;
      Serial.println(val);
    } else if (part02 == "false") {
      playerOneUp = false;
    }
          
    } else if (part01 == "playerOneDown"){
         
    }

      if (playerOneUp == true) {

          digitalWrite(motorPinUno, HIGH);
       //   Serial.println("encender Motor 1");

        } else { 
          
          digitalWrite(motorPinUno, LOW);
        //  Serial.println("apagar Motor 1");
        }


      

      if (val == "2") {
        if (!motorDosActivado) {
          digitalWrite(motorPinDos, HIGH);
          Serial.println("encender Motor 2");
        } else {
          digitalWrite(motorPinDos, LOW);
          Serial.println("apagar Motor 2");
        }
        motorDosActivado = !motorDosActivado;

      }

      if (val == "3") {
        if (!motorTresActivado) {
          digitalWrite(motorPinTres, HIGH);
          Serial.println("encender Motor 3");
        } else {
          digitalWrite(motorPinTres, LOW);
          Serial.println("apagar Motor 3");
        }
        motorTresActivado = !motorTresActivado;

      }
    
  }


    }

}

String getValue(String data, char separator, int index)
{
  int found = 0;
  int strIndex[] = {0, -1};
  int maxIndex = data.length()-1;

  for(int i=0; i<=maxIndex && found<=index; i++){
    if(data.charAt(i)==separator || i==maxIndex){
        found++;
        strIndex[0] = strIndex[1]+1;
        strIndex[1] = (i == maxIndex) ? i+1 : i;
    }
  }

  return found>index ? data.substring(strIndex[0], strIndex[1]) : "";
}
