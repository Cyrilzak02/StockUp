import './App.css';

import Button from "./Components/Button.js";
import InputFields from "./Components/InputFields.js";
function App() {
  return (
    <div className="App">
      <header className="App-header">
          <InputFields color_option={"white"} width={"200px"} height={"50px"} text={"Login"}font_color={"black"} borderRadius={"10px"} title={"email"} type={"text"}  ></InputFields>
        <Button color_option={"green"} width={"200px"} height={"50px"} text={"Login"}font_color={"white"} borderRadius={"10px"} ></Button>
      </header>
    </div>
  );
}

export default App;
