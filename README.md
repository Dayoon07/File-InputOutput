# DB 버전 : Oracle 21c xe

## DB 구조
  <h2>u_video</h2>
  <table border="1" style="border-collspace: collspace; font-size: 36px;">
    <tr>
      <td><b>필드</b></td>
      <td><b>타입</b></td>
      <td><b>제약조건</b></td>
    </tr>
    <tr>
      <td>video_id</td>
      <td>number</td>
      <td>generated, increment, pk</td>
    </tr>
    <tr>
      <td>title</td>
      <td>varchar2(255 char)</td>
      <td>not null</td>
    </tr>
    <tr>
      <td>description</td>
      <td>varchar2(500 char)</td>
      <td>-</td>
    </tr>
    <tr>
      <td>filepath</td>
      <td>varchar2(500 char)</td>
      <td>not null</td>
    </tr>
    <tr>
      <td>created</td>
      <td>varchar2(50 char)</td>
      <td>not null</td>
    </tr>
    <tr>
      <td>views</td>
      <td>number</td>
      <td>default 0</td>
    </tr>
  </table>


  <h2>u_img</h2>
  <table border="1" style="border-collspace: collspace; font-size: 36px;">
    <tr>
      <td><b>필드</b></td>
      <td><b>타입</b></td>
      <td><b>제약조건</b></td>
    </tr>
    <tr>
      <td>img_id</td>
      <td>number</td>
      <td>generated, increment, pk</td>
    </tr>
    <tr>
      <td>imgname</td>
      <td>varchar2(255 char)</td>
      <td>not null</td>
    </tr>
    <tr>
      <td>filepath</td>
      <td>clob</td>
      <td>not null</td>
    </tr>
    <tr>
      <td>datetime</td>
      <td>varchar2(50 char)</td>
      <td>not null</td>
    </tr>
    <tr>
      <td>views</td>
      <td>number</td>
      <td>default 0</td>
    </tr>
  </table>
