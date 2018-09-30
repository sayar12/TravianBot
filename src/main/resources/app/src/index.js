import './styles.css'
import React from 'react'
import {render} from 'react-dom'
import {Header} from './Header/Header'
import axios from 'axios';
import {Main} from './Main/Main'

class App extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      info: null
    }
  }

  componentDidMount() {
    axios.get('/info')
      .then(res => {
        this.setState({'info': res.data})
      })
  }

  render() {
    return (
      <div>
        <Header/>
        <Main info={this.state.info}/>
      </div>
    )
  }
}

render(<App/>, document.getElementById('app'))
