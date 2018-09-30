import React from 'react'


class SplitList extends React.Component {
  render() {
    const elements = this.props.list.map((element) =>
      <li>{element}</li>
    )
    return (
      <ul>{elements}</ul>
    )
  }
}

class MainRow extends React.Component {
  render() {
    let value = this.props.value
    if (Array.isArray(this.props.value)) {
      value = <SplitList list={this.props.value} />
    }
    return (
      <tr>
        <td>{this.props.name}:</td>
        <td>{value}</td>
      </tr>
    )
  }
}

export class Main extends React.Component {
  render() {
    if (this.props.info) {
      return (
        <div id="main">
          <table>
            <tbody>
              <MainRow name={'Server'} value={this.props.info.TRAVIAN_SERVER_URL}/>
              <MainRow name={'Username'} value={this.props.info.TRAVIAN_USERNAME}/>
              <MainRow name={'Started'} value={this.props.info.SCHEDULER_CREATED_DATETIME}/>
              <MainRow name={'Iteration'} value={this.props.info.SCHEDULER_COUNT}/>
              <MainRow name={'LastUpdated'} value={this.props.info.SCHEDULER_LAST_UPDATED_DATETIME}/>
              <MainRow name={'Actions'} value={this.props.info.ACTIONS}/>
            </tbody>
          </table>
        </div>
      )
    } else {
      return <i className="fa fa-circle-o-notch fa-spin" style={{fontSize:'30px'}}/>
    }
  }
}