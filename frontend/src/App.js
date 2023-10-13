import './css/App.css';
import Generator from './Generator'
import Validator from './Validator';

function App() {
  return (
    <div className="App">
      <Generator />
      <p>__________________________________</p>
      <Validator />
    </div>
  );
}

export default App;
