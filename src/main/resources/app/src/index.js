import './styles.css'
import React from 'react'
import {render} from 'react-dom'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'

class App extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
    }
  }

  render() {
    return (
      <Router>
        <div>
          <div>Header</div>
        </div>
      </Router>
    )
  }
}

render(<App/>, document.getElementById('app'))
