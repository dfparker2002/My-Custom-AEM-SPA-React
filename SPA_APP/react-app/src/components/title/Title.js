import React, {Component} from 'react';
import {MapTo} from '@adobe/cq-react-editable-components';

export default class Title extends Component {

    render() {
          const htmlDom = React.createElement(this.props.type, {}, this.props.title);
            return <div className="Title-class">{htmlDom} </div>
    }
}

MapTo('wknd-events/components/content/title')(Title);