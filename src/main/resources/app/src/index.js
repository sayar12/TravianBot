import './styles.css'
import React from 'react'
import {render} from 'react-dom'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import {Header} from './Header/Header'

class App extends React.Component {
  constructor(props) {
    super(props)
  }

  render() {
    return (
      <Router>
        <div>
          <Header/>
        </div>
      </Router>
    )
  }
}

render(<App/>, document.getElementById('app'))
